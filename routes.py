from flask import render_template, request, redirect, url_for, session
from models import User, Transaction, db
from sqlalchemy.exc import IntegrityError
from datetime import datetime

def cover_routes(app, db):

    @app.route('/')
    def cover():
        session.pop('user_id', None)
        return render_template('Cover/index.html')

def login_routes(app, db):

    @app.route('/login', methods=['GET', 'POST'])
    def login():
        if request.method == 'POST':
            username = request.form.get('username')
            password = request.form.get('password')

            user = User.query.filter_by(username=username).first()

            if user and user.password == password:
                session['user_id'] = user.id
                return redirect('/transaction')
            else:
                error = "Invalid username or password"
                return render_template('Login/index.html', error=error)

        return render_template('Login/index.html')

def register_routes(app, db):

    @app.route('/register', methods=['GET', 'POST'])
    def register():
        if request.method == 'POST':
            name = request.form.get('name')
            email = request.form.get('email')
            id = request.form.get('ID')
            username = request.form.get('username')
            password = request.form.get('password')
            
            if not name or not username or not password or not email or not id:
                error = 'All fields are required.'
                return render_template('Register/index.html', error=error)
            
            try:
                new_user = User(name=name, username=username, password=password, email=email, id=id)
                db.session.add(new_user)
                db.session.commit()
                success_script = "<script>alert('User registered successfully!');</script>"
                return render_template('Cover/index.html', success_script=success_script)

            except IntegrityError as e:
                if 'UNIQUE constraint failed' in str(e):
                    error = 'Username or email already exists.'
                elif 'IntegrityError' in str(e):
                    error = 'Enter a valid ID number (only numbers are allowed)'
                else:
                    error = 'An error occurred. Please try again.'
                return render_template('Register/index.html', error=error)
        
        return render_template('Register/index.html', error=None)

def transaction_routes(app, db):

    def calculate_totals(user_id):
        transactions = Transaction.query.filter_by(user_id=user_id).all()
        total_deposit = sum(t.deposit for t in transactions)
        total_withdraw = sum(t.withdraw for t in transactions)
        total_balance = total_deposit - total_withdraw
        return total_balance, total_deposit, total_withdraw

    @app.route('/transaction')
    def transaction():
        user_id = get_current_user_id()
        if user_id is None:
            return redirect(url_for('login'))
        
        total_balance, total_deposit, total_withdraw = calculate_totals(user_id)
        return render_template('Main/index.html', total_balance=total_balance, total_deposit=total_deposit, total_withdraw=total_withdraw)

    @app.route('/deposit', methods=['POST'])
    def deposit():
        amount_str = (request.form.get('amount'))

        if not amount_str.strip():
            error = "Amount cannot be empty"
            return render_template('Main/index.html', error=error)
        
        try:
            amount = float(amount_str)
        except ValueError:
            error = "Invalid amount. Please enter a valid number."
            return render_template('Main/index.html', error=error)
        
        user_id = get_current_user_id()
        if user_id is None:
            return redirect(url_for('login'))

        new_transaction = Transaction(user_id=user_id, deposit=amount, date=datetime.now().date(), time=datetime.now().time())
        db.session.add(new_transaction)
        db.session.commit()

        return redirect(url_for('transaction'))

    @app.route('/withdraw', methods=['POST'])
    def withdraw():
        amount_str = request.form.get('amount')

        if not amount_str.strip():
            error = "Amount cannot be empty"
            return render_template('Main/index.html', error=error)
        
        try:
            amount = float(amount_str)
        except ValueError:
            error = "Invalid amount. Please enter a valid number."
            return render_template('Main/index.html', error=error)
        
        user_id = get_current_user_id()
        if user_id is None:
            return redirect(url_for('login'))
        
        total_balance, _, _ = calculate_totals(user_id)

        if amount > total_balance:
            error = "Insufficient balance"
            return render_template('Main/index.html', error=error, total_balance=total_balance)

        new_transaction = Transaction(user_id=user_id, withdraw=amount, date=datetime.now().date(), time=datetime.now().time())
        db.session.add(new_transaction)
        db.session.commit()

        return redirect(url_for('transaction'))

def get_current_user_id():
    user_id = session.get('user_id')
    if user_id:
        return user_id
    else:
        return None

def table_route(app, db):

    @app.route('/table')
    def table():
        user_id = get_current_user_id()
        if user_id is None:
            return redirect(url_for('login'))

        transactions = Transaction.query.filter_by(user_id=user_id).all()
        return render_template('Table/index.html', transactions=transactions)


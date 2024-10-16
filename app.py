from flask import Flask, render_template
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

db = SQLAlchemy()

def create_app():
    app=Flask(__name__)
    app.config['SECRET_KEY'] = '56191446465pkoljnnkllfkejlk'
    app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///bank.db'
    app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
    db.init_app(app)

    
    from routes import register_routes, cover_routes, login_routes, transaction_routes,table_route
    cover_routes(app,db)
    login_routes(app,db)
    register_routes(app,db)
    transaction_routes(app,db)
    table_route(app,db)

    migrate=Migrate(app,db)

    return app

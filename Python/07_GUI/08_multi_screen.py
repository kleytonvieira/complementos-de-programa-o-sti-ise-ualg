from kivy.app import App
from kivy.uix.screenmanager import ScreenManager, Screen

utilizadores = {
    "ze": "123",
    "quim": "321"
}

class LoginScreen(Screen):
    def login(self):
        try:
            if utilizadores[self.ids.user.text] == self.ids.password.text:
                self.manager.current = "main"
            else:
                print('Falhou: password errada!')
        except:
            print('Falhou: utilizador não existe')

class MainScreen(Screen):
    def logout(self):
            self.manager.current = 'login'

class Multi_ScreenApp(App):
    def build(self):
        sm = ScreenManager()
        sm.add_widget(LoginScreen(name="login"))
        sm.add_widget(MainScreen(name="main"))
        return sm

Multi_ScreenApp().run()
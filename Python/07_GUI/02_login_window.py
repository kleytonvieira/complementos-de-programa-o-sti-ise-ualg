from kivy.app import App
from kivy.uix.label import Label
from kivy.uix.textinput import TextInput
from kivy.uix.gridlayout import GridLayout

# This class is used as a Base for our RootWidget (LoginScreen)
class LoginScreen(GridLayout):

    # override the method __init__() so as to add widgets and to define their behavior
    def __init__(self, **kargs):
        # call super in order to implement the functionality of the original class being
        # overloaded.
        super().__init__(**kargs)
        # GridLayout to manage its children in two columns and add a Label and a TextInput for
        # the username and password.
        self.cols = 2

        self.add_widget(Label(text='Nome:'))
        self.add_widget(TextInput(multiline=False))

        self.add_widget(Label(text='Palavra-chave:'))
        self.add_widget(TextInput(multiline=False, password=True))


class MyApp(App):
    def build(self):
        return LoginScreen()

if __name__ == '__main__':
    MyApp().run()
from kivy.app import App
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.gridlayout import GridLayout
from kivy.uix.textinput import TextInput
from kivy.uix.button import Button
from kivy.uix.label import Label

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



# This class is used as a Base for our RootWidget (LoginScreen)
class LoginScreen_2(GridLayout):

    # override the method __init__() so as to add widgets and to define their behavior
    def __init__(self, **kargs):
        # call super in order to implement the functionality of the original class being
        # overloaded.
        super().__init__(**kargs)
        # GridLayout to manage its children in two columns and add a Label and a TextInput for
        # the username and password.
        self.cols = 3

        self.add_widget(Label(text='Nome:'))
        self.add_widget(TextInput(multiline=False))

        box_layout = BoxLayout()
        box_layout.orientation = 'vertical'
        box_layout.add_widget(Button(text='ok'))
        box_layout.add_widget(Button(text='Cancelar'))

        self.add_widget(box_layout)


class MyApp(App):
    def build(self):
        # return LoginScreen()
        return LoginScreen_2()

MyApp().run()
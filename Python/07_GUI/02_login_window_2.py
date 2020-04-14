from kivy.app import App
from kivy.uix.label import Label
from kivy.uix.textinput import TextInput
from kivy.uix.button import Button
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
        self.txt_input_nome = TextInput(multiline=False)
        self.txt_input_nome.bind(text=self.muda_cor)
        self.add_widget(self.txt_input_nome)

        self.add_widget(Label(text='Palavra-chave:'))
        self.txt_input_pw = TextInput(multiline=False, password=True)
        self.txt_input_pw.bind(text=self.muda_cor)
        self.add_widget(self.txt_input_pw)

        bt_verifica = Button(text='Verifica')
        bt_verifica.bind(on_release=self.bt_release)
        self.add_widget(bt_verifica)

        self.lb_verifica = Label(text='')
        self.add_widget(self.lb_verifica)

    def bt_release(self, instance):
        # print(instance)
        # pprint(self.txt_input_nome.__dict__)
       self.lb_verifica.text = 'ok' if self.txt_input_nome.text == self.txt_input_pw.text else 'not ok!'

    def muda_cor(self, instance, value):
        self.lb_verifica.text = 'clique no botão verificar'
        self.lb_verifica.color = [0, 1, 0, 1] if self.txt_input_nome.text == self.txt_input_pw.text else [1, 0, 0, 1]

class MyApp(App):
    def build(self):
        return LoginScreen()

if __name__ == '__main__':
    MyApp().run()
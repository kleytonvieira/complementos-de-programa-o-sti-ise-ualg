from kivy.app import App
from kivy.uix.label import Label


class MyApp(App):
    # this is the function where you should initialize and return your Root Widget
    def build(self):
        # This Label will be the Root Widget of this App.
        return Label(text='Olá CP/STI!')


if __name__ == '__main__':
    # class MyApp is initialized and its run() method called.
    # This initializes and starts our Kivy application.
    MyApp().run()

from kivy.app import App
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.gridlayout import GridLayout
from kivy.uix.textinput import TextInput
from kivy.uix.button import Button
from kivy.uix.label import Label
from kivy.uix.checkbox import CheckBox
from kivy.uix.progressbar import ProgressBar
from kivy.uix.spinner import Spinner
from kivy.uix.togglebutton import ToggleButton

from kivy.core.window import Window
Window.size = (500, 600)



class Formulario(BoxLayout):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)

        self.orientation = 'vertical'
        self.padding = 20

        # define grelha para label e txt
        grid_label_txt = GridLayout(cols=2)
        self.add_widget(grid_label_txt)

        # ------
        grid_label_txt.add_widget(Label(text='Nome'))

        self.txt_nome = TextInput(multiline=False)
        grid_label_txt.add_widget(self.txt_nome)
        self.txt_nome.bind()

        # ------
        grid_label_txt.add_widget(Label(text='Email'))

        self.txt_email = TextInput(multiline=False)
        grid_label_txt.add_widget(self.txt_email)

        # ------
        grid_label_txt.add_widget(Label(text='Tem carro'))

        self.chk_carro = CheckBox()
        grid_label_txt.add_widget(self.chk_carro)

        # ------
        grid_label_txt.add_widget(Label(text='Sexo'))
        sex_grid = GridLayout(cols=2)

        sex_grid.add_widget(Label(text = 'Masculino'))
        self.sexo_m = CheckBox(group='sexo')
        sex_grid.add_widget(self.sexo_m)

        sex_grid.add_widget(Label(text = 'Feminino'))
        self.sexo_f = CheckBox(group='sexo')
        sex_grid.add_widget(self.sexo_f)

        grid_label_txt.add_widget(sex_grid)

        # ------
        grid_label_txt.add_widget(Label(text='País'))

        self.spinner_pais = Spinner(
            text='Nacionalidade',
            values=('Portugal', 'Espanha', 'França', 'Itália')
        )
        grid_label_txt.add_widget(self.spinner_pais)

        # define outra grelha para os 4 botões
        grid_bts = GridLayout(cols=5)
        self.add_widget(grid_bts)

        self.bt_novo = Button(text='Novo')
        self.bt_novo.bind(on_release=self.botao_clicado)
        grid_bts.add_widget(self.bt_novo)

        self.bt_apaga = Button(text='Apaga')
        self.bt_apaga.bind(on_release=self.botao_clicado)
        grid_bts.add_widget(self.bt_apaga)

        self.bt_grava = Button(text='Grava')
        self.bt_grava.bind(on_release=self.botao_clicado)
        grid_bts.add_widget(self.bt_grava)

        self.bt_anterior = Button(text='Anterior')
        self.bt_anterior.bind(on_release=self.botao_clicado)
        grid_bts.add_widget(self.bt_anterior)

        self.bt_proximo = Button(text='Próximo')
        self.bt_proximo.bind(on_release=self.botao_clicado)
        grid_bts.add_widget(self.bt_proximo)

        self.barra_de_progresso = ProgressBar(max=100, value=0)
        self.add_widget(self.barra_de_progresso)

        self.utilizadores = [
            {'nome': 'ze', 'email': 'ze@ualg.pt', 'carro': True, 'pais': 'Portugal'},
            {'nome': 'quim', 'email': 'quim@ualg.pt', 'carro': False, 'pais': 'Espanha'}
        ]
        self.idx = 0

        self.atualiza_formulario()

    def atualiza_formulario(self):
        print(self.idx)
        if self.idx >= 0:
            self.txt_nome.text = self.utilizadores[self.idx]['nome']
            self.txt_email.text = self.utilizadores[self.idx]['email']
            self.barra_de_progresso.value = ( self.idx + 1.) / len(self.utilizadores) * 100
            self.chk_carro.active = self.utilizadores[self.idx]['carro']
            self.spinner_pais.text = self.utilizadores[self.idx]['pais']
        else:
            self.txt_nome.text = 'Sem registos.'
            self.txt_email.text = 'Sem registos.'


    def botao_clicado(self, instance):
        if instance == self.bt_novo:
            self.utilizadores.append({'nome': '?', 'email': '?', 'carro': '?', 'pais': '?'})
            self.idx = len(self.utilizadores) - 1
        elif instance == self.bt_apaga:
            if self.idx >= 0:
                del self.utilizadores[self.idx]
                self.idx = self.idx if self.idx < len(self.utilizadores) else len(self.utilizadores) - 1
        elif instance == self.bt_grava:
            if self.idx >= 0:
                self.utilizadores[self.idx]['nome'] = self.txt_nome.text
                self.utilizadores[self.idx]['email'] = self.txt_email.text
                self.utilizadores[self.idx]['carro'] = self.chk_carro.active
                self.utilizadores[self.idx]['pais'] = self.spinner_pais.text
        elif instance == self.bt_anterior:
            self.idx -= 1
            if self.idx < 0:
                self.idx = len(self.utilizadores) - 1
        elif instance == self.bt_proximo:
            self.idx += 1
            if self.idx >= len(self.utilizadores):
                self.idx = - 1 if len(self.utilizadores) == 0 else 0
        else:
            self.idx = -1
            print("Algo correu mal!!!")

        self.atualiza_formulario()




class MyApp(App):
    def build(self):
        return Formulario()

MyApp().run()
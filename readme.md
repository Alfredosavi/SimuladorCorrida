
# Simulador de Corrida de Veículos
Um simulador de corrida de veículos irá controlar veículos do tipo bicicleta, motocicleta, carro popular e ferrari através de seu centro de comandos. Os veículos estarão competindo no estilo
corrida.
Cada veículo criado possuirá uma identificação única (que deverá ser gerada automaticamente),
uma quantidade de rodas e uma quantidade de combustível (para aqueles que possuem motor).
Os veículos motorizados devem ser abastecidos e consomem combustível à medida que se
deslocam. Eles apenas se movimentam se há combustível suficiente para tal e se os pneus das
rodas estiverem calibrados. Assume-se que para mover um traço:
- Motocicleta gasta 0,5 litro,
- Carro polular gasta um litro,
-  Ferrari gasta 1,5 litros de combustível.

O veículo não deve se movimentar se ele não possuir a quantidade de combustível suficiente e se seus pneus não estiverem calibrados.
Os veículos se movem sempre na horizontal da esquerda para direita de acordo com suas
respectivas quantidades de traços (unidade de movimento):
* **Bicicleta:** de um em um traço,
* **Motocicleta:** de três em três traços,
* **Carro popular:** de cinco em cinco traços,
* **Ferrari:** de dez em dez traços.


#### 🎓 Com base no detalhamento anterior, faça:
1. Descreva o diagrama UML das classes do simulador tomando como modelo o esboço apresentado na Figura 1 (gerar o arquivo pdf do diagrama).

2. Com base do diagrama UML elaborado acima, desenvolva um aplicativo Java com um menu interativo que permita ao usuário executar o simulador de corrida de veículos com no máximo 20 veículos:
	* (a) Incluir veículo
	    * Solicitar o tipo do veículo (B, M, C, F). Gerar um id automático para o veículo criado e assumir que os pneus estão vazios.
	    * Para os veículos motorizados, considerar que estão sem combustível.
	 * (b) Remover um veículo (deve-se informar o identificador do veículo).
     * (c) Abastecer veículo (deve-se informar o identificador do veículo e a quantidade de combustível em litros).
	 * (d) Movimentar veículo (deve-se informar o identificador do veículo).
     * (e) Movimentar veículos por tipo (deve-se informar o tipo de veículo e movimentar todos os veículos daquele tipo).
     * (f) Imprimir dados de veículos por tipo (deve-se informar o tipo de veículo e imprimir os dados de todos os veículos daquele tipo).
    * (g) Imprimir pista de corrida (imprime na ordem em que estão no array os veículos com    seus respectivos traços percorridos, como mostra o exemplo abaixo:
        * O identificador do veículo na pista de corrida será composto pela sua sigla (B para        bicicleta, M para motocicleta, C para carro popular e F para ferrari) concatenado com o id do veículo.
     * (h) Esvaziar pneus de um veículo.
     * (i) Calibrar pneus de um veículo.
     * (j) Sair da aplicação

 ```sh
|F1
|B2
|C3
|M4
|B5
|----------F1
|-B2
|-----C3
|---M4
|-B5
```


    
    
### 📝 Créditos
* Alfredo Savi
* Guilherme Manassés
* Luciene de Oliveira Marin (prof) 
* Rozimery Ferreira

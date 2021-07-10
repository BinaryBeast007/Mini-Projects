/*
 * Tic Tac Toe
 * Author  : Abu Sayem
 * Created : 02/10/2020
*/
#include<bits/stdc++.h>
using namespace std;

char square[10] = {'X','1','2','3','4','5','6','7','8','9'};

void computerTurn();
void humanTurn();
int checkWin();
void board();

int main() {
    srand(time(0));
    int move = 9;
    do{
        board();
        (move%2) ? humanTurn() : computerTurn();
        int win = 0;
        if(move < 6){
            win = checkWin();
            if(win == 2){
                board();
                cout << "\nMatch Draw :(\n";
            }else if(win == 1){
                board();
                if(move%2){
                    cout << "\nCongratulations! You Win :D\n";
                }else{
                    cout << "\nOpps! :(\nComputer Wins. Better luck next time :)\n";
                }
                return 0;
            }
        }
        move--;
    }while(move);

    return 0;
}

void computerTurn() {
    int choice;
    choice = rand()%9 + 1;
    if (square[choice] == 'X' || square[choice] == 'O'){
        computerTurn();
    }else{
        square[choice] = 'O';
    }
}

void humanTurn() {
    char choice;
    cout << "\nEnter your choice  : ";
    cin >> choice;
    
    if(choice < '1' || choice > '9'){
        board();
        cout<<"\nInvalid move. Try again.";
        humanTurn();
    }else{
        int int_choice = choice - '0';
        if(square[int_choice] == choice )
            square[int_choice] = 'X';
        else{
            board();
            cout<<"\nInvalid move. Try again.";
            humanTurn();
        }
    }
}

void board() {
    system("cls"); cout << "\033[2J\033[1;1H";

    cout << "\n\n    Tic Tac Toe\n\n";
    cout << "Human (X) - Computer (O)" << "\n\n";

    cout << "     |     |\n";
    cout << "  " << square[1] << "  |  " << square[2] << "  |  " << square[3] << "\n";
    cout << "_____|_____|_____\n";
    cout << "     |     |\n";
    cout << "  " << square[4] << "  |  " << square[5] << "  |  " << square[6] << "\n";
    cout << "_____|_____|_____\n";
    cout << "     |     |\n";
    cout << "  " << square[7] << "  |  " << square[8] << "  |  " << square[9] << "\n"; 
    cout << "     |     |\n";
}

int checkWin() {
    if (square[1] == square[2] && square[2] == square[3]){
        return 1;
    }else if (square[4] == square[5] && square[5] == square[6]){
        return 1;
    }else if (square[7] == square[8] && square[8] == square[9]){
        return 1;
    }else if (square[1] == square[4] && square[4] == square[7]){
        return 1;
    }else if (square[2] == square[5] && square[5] == square[8]){
        return 1;
    }else if (square[3] == square[6] && square[6] == square[9]){
        return 1;
    }else if (square[1] == square[5] && square[5] == square[9]){
        return 1;
    }else if (square[3] == square[5] && square[5] == square[7]){
        return 1;
    }else if (square[1] != '1' && square[2] != '2' && square[3] != '3' && square[4] != '4' && square[5] != '5' && square[6] != '6' && square[7] != '7' && square[8] != '8' && square[9] != '9'){
        return 2;
    }else{
        return -1;
    }
}

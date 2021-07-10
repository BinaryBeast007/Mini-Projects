/*
 * Rock Paper Scissor
 * Author  : Abu Sayem
 * Created : 02/10/2020
*/
#include<iostream>
#include<time.h>
using namespace std;

int main() {
	char choice;

	cout<<"WELCOME TO ROCK PAPER SCISSOR GAME"<<endl
		<<"Developed by Abu Sayem\n\n"
		<<"Choose Game Mode    [Press 1/2/3]\n"
		<<"1. Copmuter Wins Always\n"
		<<"2. You Win Always\n"
		<<"3. A Fare Gameplay\n"
		<<"Enter Your Choice: ";
	int mode_choice;
	cin>> mode_choice;
	if(mode_choice == 1){
		while(1){
			cout<<"Enter r p or s\n";
			cin>> choice;
			if(choice == 'r'){
				cout<<"You choose ROCK. Copmuter choose PAPER.\nYou Lose.\n";
			}else if (choice == 'p'){
				cout<<"You choose PAPER. Copmuter choose SCISSOR.\nYou Lose.\n";
			}else if (choice== 's'){
				cout<<"You choose SCISSOR. Copmuter choose ROCK.\nYou Lose.\n";
			}else{
				cout<<"You Have Enter Wrong Character\n";
			}
		}
	}else if (mode_choice==2){
		while(1){
			cout<<"Enter r p or s\n";
			cin>> choice;
			if(choice == 'r'){
				cout<<"You choose ROCK. Copmuter choose SCISSOR.\nYou Win.\n";
			}else if (choice == 'p'){
				cout<<"You choose PAPER. Copmuter choose ROCK.\nYou Win.\n";
			}else if (choice== 's'){
				cout<<"You choose SCISSOR. Copmuter choose PAPER.\nYou Win.\n";
			}else{
				cout<<"You Have Enter Wrong Character\n";
			}
		}
	}else if (mode_choice==3){
		while(1){
			// 1 as "Rock"
			// 2 as "Paper"
			// 3 as "Scissor"
			srand(time(0));
			int comp_choice = rand()%3 + 1;
			cout<<"Enter r p or s\n";
			cin>> choice;
			if(choice == 'r'){
				if(comp_choice == 1){
					cout<<"You choose ROCK. Copmuter choose ROCK.\nMatch Draw.\n";
				}else if(comp_choice == 2){
					cout<<"You choose ROCK. Copmuter choose PAPER.\nYou Lose.\n";
				}else{
					cout<<"You choose ROCK. Copmuter choose SCISSOR.\nYou Win.\n";
				}
			}else if (choice == 'p'){
				if(comp_choice == 1){
					cout<<"You choose PAPER. Copmuter choose ROCK.\nYou Win.\n";
				}else if(comp_choice == 2){
					cout<<"You choose PAPER. Copmuter choose PAPER.\nMatch Draw.\n";
				}else{
					cout<<"You choose PAPER. Copmuter choose SCISSOR.\nYou Lose.\n";
				}
			}else if(choice == 's'){
				if(comp_choice == 1){
					cout<<"You choose SCISSOR. Copmuter choose ROCK.\nYou Lose.\n";
				}else if(comp_choice == 2){
					cout<<"You choose SCISSOR. Copmuter choose PAPER.\nYou Win.\n";
				}else{
					cout<<"You choose SCISSOR. Copmuter choose SCISSOR.\nMatch Draw.\n";
				}
			}else{
				cout<<"You Have Enter Wrong Character\n";
			}
		}
	}else{
		cout<<"You Have Enter Wrong Character\n";
	}

	return 0;
}

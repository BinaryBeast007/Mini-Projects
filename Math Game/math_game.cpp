#include<bits/stdc++.h>
#include<unistd.h>
using namespace std;

char intro();
char showLevels();
void calculation(char choice, char level);

int main() {
	char choice = intro();
	char level;
	if(choice != '6')
		level = showLevels();
	calculation(choice, level);

	return 0;
}

char intro() {
	system("cls");
	cout << "Loading";
	for(int i=0; i<3; i++){
		sleep(1);
		cout << ".";
	}
	system("cls");

	cout << "******************************\n";
	cout << "	  MATH GAME\n";
	cout << "******************************\n\n";
	cout << "Choose a game to play\n\n";
	cout << "1. Addition Game\n2. Subtraction Game\n3. Division Game\n4. Multiplication Game\n5. Random Operator\n6. Guessing Game\n\n";
	enterChoice:
	cout << "Enter your choice : ";
	char choice;
	cin >> choice;
	if(choice < '1' || choice > '6'){
		cout << "Invalid Input. Try Again.\n";
		goto enterChoice;
	}
	return choice;
}

char showLevels() {
	cout << "\nChoose difficulty level : \n";
	cout << "1. Easy [Upto 1 digit calculation]\n2. Medium [Upto 2 digit calculation]\n3. Hard [Upto 3 digit calculation]\n";
	enterLevel:
	cout << "Enter your choice : ";
	char level;
	cin >> level;
	if(level < '1' || level > '3'){
		cout << "Invalid Input. Try Again.\n";
		goto enterLevel;
	}
	return level;
}

void calculation(char choice, char level) {
	system("cls");
	if(choice == '1')
		cout << "Welcome to level " << level << " Addition game\n\n";
	else if(choice == '2')
		cout << "Welcome to level " << level << " Subtraction game\n\n";
	else if(choice == '3')
		cout << "Welcome to level " << level << " Division game\n\n";
	else if(choice == '4')
		cout << "Welcome to level " << level << " Multiplication game\n\n";
	else if(choice == '5')
		cout << "Welcome to level " << level << " Random Operator game\n\n";
	else if(choice == '6')
		cout << "Welcome to Guessing game\n\n";

	int turn = 5, points = 0;
	double ans, guessAns;
	char opp = choice;
	while(turn--) {
		srand(time(0));
		int num1 = rand(), num2 = rand();
		if(level == '1'){
			num1 %= 10; num2 %= 10;
			num1++; num2++;
		}else if(level == '2'){
			num1 %= 100; num2 %= 100;
			num1++; num2++;
		}else if(level == '3'){
			num1 %= 1000; num2 %= 1000;
			num1++; num2++;
		}
		if(opp == '5'){
			string s = to_string((rand() % 4) + 1);
			choice = s[0];
		}

		if(choice == '1'){
			cout << num1 << " + " << num2 << " = ?\n";
			cin >> guessAns;
			ans = num1 + num2;
			if(ans == guessAns){
				points += 2;
				cout << "Your answer was correct. Points +2\n";
			}else{
				cout << "Your answer was wrong. Points +0\n";
				cout << "Correct Answer : " <<  num1 << " + " << num2 << " = " << ans << "\n";
			}
		}else if(choice == '2'){
			cout << num1 << " - " << num2 << " = ?\n";
			cin >> guessAns;
			ans = num1 - num2;
			if(ans == guessAns){
				points += 2;
				cout << "Your answer was correct. Points +2\n";
			}else{
				cout << "Your answer was wrong. Points +0\n";
				cout << "Correct Answer : " <<  num1 << " - " << num2 << " = " << ans << "\n";
			}
		}else if(choice == '3'){
			cout << num1 << " / " << num2 << " = ?\n";
			cin >> guessAns;
			ans = (double) num1 / (double) num2;
			if(ans == guessAns){
				points += 2;
				cout << "Your answer was correct. Points +2\n";
			}else{
				cout << "Your answer was wrong. Points +0\n";
				cout << "Correct Answer : " <<  num1 << " / " << num2 << " = " << ans << "\n";
			}
		}else if(choice == '4'){
			cout << num1 << " * " << num2 << " = ?\n";
			cin >> guessAns;
			ans = num1 * num2;
			if(ans == guessAns){
				points += 2;
				cout << "Your answer was correct. Points +2\n";
			}else{
				cout << "Your answer was wrong. Points +0\n";
				cout << "Correct Answer : " <<  num1 << " * " << num2 << " = " << ans << "\n";
			}
		}else if(choice == '6'){
			num1 %= 10; num1++;
			cout << "Guess a number between 1 to 10\n";
			cin >> guessAns;
			if(num1 == guessAns){
				points += 2;
				cout << "Your guess was correct. Points +2\n";
			}else{
				cout << "Your guess was wrong. Points +0\n";
				cout << "Number was : " <<  num1 << "\n";
			}
		}
		cout << "Your Points = " << points << "\n\n";
	}
	cout << "******************************\n";
	cout << "       Session Ended\n\n";
	cout << "Final Points " << points << " out of 10" << "\n\n";
	char decision;
	cout << "Wanna play again? [Press 'y' for Yes or any key for Exit]\n";
	cin >> decision;
	decision == 'y' ? main() : puts("Program Terminated\n");
}

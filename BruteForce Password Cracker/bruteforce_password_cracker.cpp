/*
 * Ceasar Cipher Technique
 * Author  : Abu Sayem
 * Created : 22/10/2020
 * Version : 1.0.0
*/
#include<bits/stdc++.h>
#include<unistd.h>
#include <chrono>
using namespace std;
#define watch(x) 		cout << (#x) << " = " << (x) << endl
long long int attempts = 0;
void bruteForcePassword(string userPassword);
void passwordCracked(string brutePassword);
void beforeAttempt(int passLen);
void afterAttempt(int passLen);
void passwordNotFound();
void estimatedTime(string userPassword);

int main()
{
    string userPassword;
    system("cls");
    start:
    cout << "Choose an option :\n1. Estimate the time and attempts\n2. Crack the password\n";
    char ch;
    cin >> ch;
    if(ch < '1' || ch > '2'){ 
        cout << "Invalid input. Try again\n";
        goto start;
    }
    cout << "Enter a password  to crack : " << "\n";
    cin >> userPassword;
    if(ch == '1'){
        estimatedTime(userPassword);
        return 0;
    }
    auto begin = std::chrono::high_resolution_clock::now();
    bruteForcePassword(userPassword);
    auto end = std::chrono::high_resolution_clock::now();
    auto elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - begin);    
    printf("Time Measured\t: %.5f seconds\n", elapsed.count() * 1e-9);
    cout << "\n>> Cracked by BinaryBeast007 <<\n";

    return 0;
}

void bruteForcePassword(string userPassword){
    string passwordCharacters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", brutePassword;
    int len = passwordCharacters.length(), passLen = 1;
    beforeAttempt(passLen); attempts = 0;
    // cracking length 1 password
    for(int i = 0; i < len; i++){
        attempts++;
        brutePassword = "";
        brutePassword += passwordCharacters[i];
        if(brutePassword == userPassword){
            passwordCracked(brutePassword); return;
        }
    }
    afterAttempt(passLen); passLen++; beforeAttempt(passLen);
    // cracking length 2 password
    for(int i = 0; i < len; i++){
        for(int j = 0; j < len; j++){
            attempts++;
            brutePassword = "";
            brutePassword += passwordCharacters[i];
            brutePassword += passwordCharacters[j];
            if(brutePassword == userPassword){
                passwordCracked(brutePassword); return;
            }
        }
    }
    afterAttempt(passLen); passLen++; beforeAttempt(passLen);
    // cracking length 3 password
    for(int i = 0; i < len; i++){
        for(int j = 0; j < len; j++){
            for(int k = 0; k < len; k++){
                attempts++;
                brutePassword = "";
                brutePassword += passwordCharacters[i];
                brutePassword += passwordCharacters[j];
                brutePassword += passwordCharacters[k];
                if(brutePassword == userPassword){
                    passwordCracked(brutePassword); return;
                }
            }
        }
    }
    afterAttempt(passLen); passLen++; beforeAttempt(passLen);
    double percentage = 0; cout << fixed << setprecision(0);
    // cracking length 4 password
    for(int i = 0; i < len; i++){
        for(int j = 0; j < len; j++){
            for(int k = 0; k < len; k++){
                for(int l = 0; l < len; l++){
                    attempts++;
                    if(attempts % 250000 == 0){
                        cout << '.';
                    }
                    if(attempts % (15018570/10) == 0){
                        percentage += 10; cout << " " << percentage << "% ";
                    }
                    brutePassword = "";
                    brutePassword += passwordCharacters[i];
                    brutePassword += passwordCharacters[j];
                    brutePassword += passwordCharacters[k];
                    brutePassword += passwordCharacters[l];
                    if(brutePassword == userPassword){
                        passwordCracked(brutePassword); return;
                    }
                }
            }
        }
    }
    afterAttempt(passLen); passLen++; beforeAttempt(passLen), percentage = 0;
    // cracking length 5 password
    for(int i = 0; i < len; i++){
        for(int j = 0; j < len; j++){
            for(int k = 0; k < len; k++){
                for(int l = 0; l < len; l++){
                    for(int m = 0; m < len; m++){
                        attempts++;
                        if(attempts % 2500000 == 0){
                            cout << '.';
                        }
                        if(attempts % (931151402/50) == 0){
                            percentage += 2; cout << " " << percentage << "% ";
                        }
                        brutePassword = "";
                        brutePassword += passwordCharacters[i];
                        brutePassword += passwordCharacters[j];
                        brutePassword += passwordCharacters[k];
                        brutePassword += passwordCharacters[l];
                        brutePassword += passwordCharacters[m];
                        if(brutePassword == userPassword){
                            passwordCracked(brutePassword); return;
                        }
                    }
                }
            }
        }
    }
    afterAttempt(passLen); passLen++; beforeAttempt(passLen), percentage = 0;
    cout << fixed << setprecision(1);
    // cracking length 6 password
    for(int i = 0; i < len; i++){
        for(int j = 0; j < len; j++){
            for(int k = 0; k < len; k++){
                for(int l = 0; l < len; l++){
                    for(int m = 0; m < len; m++){
                        for(int n = 0; n < len; n++){
                            attempts++;
                            if(attempts % 2500000 == 0){
                                cout << '.';
                            }
                            if(attempts % ((long long int)57731386986/1000) == 0){
                                percentage += 0.1; cout << " " << percentage << "% ";
                            }
                            brutePassword = "";
                            brutePassword += passwordCharacters[i];
                            brutePassword += passwordCharacters[j];
                            brutePassword += passwordCharacters[k];
                            brutePassword += passwordCharacters[l];
                            brutePassword += passwordCharacters[m];
                            brutePassword += passwordCharacters[n];
                            if(brutePassword == userPassword){
                               passwordCracked(brutePassword); return;
                            }
                        }
                    }
                }
            }
        }
    }
    // cracking length 7 password
    afterAttempt(passLen); passLen++; beforeAttempt(passLen), percentage = 0;
    cout << fixed << setprecision(0);
    for(int i = 0; i < len; i++){
        for(int j = 0; j < len; j++){
            for(int k = 0; k < len; k++){
                for(int l = 0; l < len; l++){
                    for(int m = 0; m < len; m++){
                        for(int n = 0; n < len; n++){
                            for(int o = 0; o < len; o++){
                                attempts++;
                                if(attempts % 2500000 == 0){
                                    cout << '.';
                                }
                                if(attempts % ((long long int)3579345993194/10000) == 0){
                                    percentage += 0.01; cout << " " << percentage << "% ";
                                }
                                brutePassword = "";
                                brutePassword += passwordCharacters[i];
                                brutePassword += passwordCharacters[j];
                                brutePassword += passwordCharacters[k];
                                brutePassword += passwordCharacters[l];
                                brutePassword += passwordCharacters[m];
                                brutePassword += passwordCharacters[n];
                                brutePassword += passwordCharacters[o];
                                if(brutePassword == userPassword){
                                passwordCracked(brutePassword); return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    passwordNotFound();
}

void estimatedTime(string userPassword){
    string passwordCharacters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    vector<long long int> v(userPassword.length());
    long long estAttempts = 0;
    reverse(userPassword.begin(), userPassword.end());
    for(int i=0; i<userPassword.length(); i++){
        for(int j=0; j<62; j++){
            if(userPassword[i] == passwordCharacters[j]){
                v[i] = (j+1) * pow(62, i);
                estAttempts += v[i];
            }
        }
    }
    auto begin = std::chrono::high_resolution_clock::now();
    bruteForcePassword("ZZZZ");
    auto end = std::chrono::high_resolution_clock::now();
    auto elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - begin);
    auto estTime = (elapsed.count() * 1e-9) / attempts;
    system("cls");
    reverse(userPassword.begin(), userPassword.end());
    cout << "The Password : " << userPassword << "\n";
    printf("Estimated Time : %.5f seconds\n", estTime*estAttempts);
    // cout << "Estimated Time : " << (double)estTime*estAttempts << "\n";
    cout << "Estimated Attempts : " << estAttempts << "\n";
}

void passwordCracked(string brutePassword){
    // system("cls");
    cout << "\n\n>\n>> PASSWORD CRACKED!\n>\n\nThe Password\t: " << brutePassword << "\n";
    cout << "Total Attempts\t: " << attempts << "\n";
}

void beforeAttempt(int passLen){
    cout << "\nBrute forcing length " << passLen <<" passwords. Please wait...";
}

void afterAttempt(int passLen){
    cout << "\nCouldn't find the password.\n>\n>> Password length is not " << passLen << "\n>\n";
    cout << "\nIncreasing the searching level by increasing the password length\n";
}

void passwordNotFound(){
    cout << ">\n>> PASSWORD NOT FOUND!\n>\n\nYou may have entered more than length 7 password or you have used special character in your password\n";
}

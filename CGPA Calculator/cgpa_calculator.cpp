#include<bits/stdc++.h>
using namespace std;

int main() {
    cout << "HOW MANY COURSES?\n";
    int courses; cin >> courses;
    double gradePoint = 0, credit = 0;
    unordered_map<string, double> gradeMap = {{"A+", 4.00}, {"A", 3.75}, {"B+", 3.50},  {"B", 3.25}, {"C+", 3.00}, {"C", 2.75}, {"D+", 2.50}, {"D", 2.25}, {"F", 0.00}};
    vector<pair<string, int>> courseInfo;

    for(int i=1; i<=courses; i++) {
        cout << "COURSE " << i << " INFORMATION\n";
        pair<string, int> info;
        cout << "GRADE : ";
        cin >> info.first;
        cout << "CREDIT : ";
        cin >> info.second;
        courseInfo.emplace_back(info);
        // calculating grade point
        info.first[0] = toupper(info.first[0]);
        gradePoint += (gradeMap[info.first] * info.second);
        credit += info.second;
    }

    double cgpa = gradePoint / credit;
    cout << "\n\n-------------------------------------\n\n";
    cout << "GRADE POINT : " << gradePoint << "\n";
    cout << "CREDIT : " << credit << "\n";
    cout << "CGPA : " << fixed << setprecision(2) << cgpa << "\n";
    cout << "\n-------------------------------------\n";

    return 0;
}

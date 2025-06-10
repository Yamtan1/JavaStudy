import 'dart:io';

class Student {
  String name;
  int kor;
  int eng;
  int math;

  Student(this.name, this.kor, this.eng, this.math);

  int get total => kor + eng + math;
  double get average => total / 3;

  @override
  String toString() {
    return '$name\t$kor\t$eng\t$math\t$total\t${average.toStringAsFixed(2)}';
  }
}

class StudentManager {
  List<Student> students = [];

  void addStudent(Student student) {
    students.add(student);
  }

  void printAllStudents() {
    print('\n[전체 학생 성적]');
    print('이름\t국어\t영어\t수학\t총점\t평균');
    for (var s in students) {
      print(s);
    }
  }

  void saveToFile(String filename) {
    final file = File(filename);
    final sink = file.openWrite();
    sink.writeln('이름\t국어\t영어\t수학\t총점\t평균');
    for (var s in students) {
      sink.writeln(s);
    }
    sink.close();
  }
}

void main() {
  final manager = StudentManager();

  print('📘 학생 성적 입력 프로그램');
  print("학생 정보를 입력하세요. 종료하려면 이름에 'exit'을 입력하세요.");

  while (true) {
    stdout.write('\n이름: ');
    String? name = stdin.readLineSync();
    if (name == null || name.trim().toLowerCase() == 'exit') break;

    stdout.write('국어 점수: ');
    int? kor = int.tryParse(stdin.readLineSync() ?? '');
    stdout.write('영어 점수: ');
    int? eng = int.tryParse(stdin.readLineSync() ?? '');
    stdout.write('수학 점수: ');
    int? math = int.tryParse(stdin.readLineSync() ?? '');

    if (kor == null || eng == null || math == null) {
      print('[오류] 점수는 숫자로 정확히 입력해주세요.');
      continue;
    }

    manager.addStudent(Student(name.trim(), kor, eng, math));
    print('[+] $name 학생 정보가 저장되었습니다.');
  }

  manager.printAllStudents();
  manager.saveToFile('students.txt');
  print('\n📂 students.txt 파일에 학생 성적이 저장되었습니다.');
}

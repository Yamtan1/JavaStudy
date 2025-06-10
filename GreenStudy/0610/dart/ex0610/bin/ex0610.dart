import 'dart:io';

void main() { 
  var tmpInput;
  stdout.write("[3] Single number : ");
  tmpInput = stdin.readLineSync();
  stdout.writeln("[3] You wrote : $tmpInput and its type is ${tmpInput.runtimeType}");

}

int x=5;

void main() {
	System.out.println("Hello World!");
	showX();
//	new Other().test(); This should compile but it doesn't
}

void showX(){
	System.out.println(x);
}

class SomeOtherClass{}
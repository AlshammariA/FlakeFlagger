@Test public void testMatching_curlyBraces(){
  assertThat("{a,b}").matches("a","b").doesNotMatch("/","c","0","",",","{","}");
  assertThat("{ab,cd}").matches("ab","cd").doesNotMatch("bc","ac","ad","ba","dc",",");
  assertThat(".{h,cc}").matches(".h",".cc").doesNotMatch("h","cc");
  assertThat("{?oo,ba?}").matches("foo","boo","moo","bat","bar","baz");
  assertThat("{[Ff]oo*,[Bb]a*,[A-Ca-c]*/[!z]*.txt}").matches("foo","Foo","fools","ba","Ba","bar","Bar","Bart","c/y.txt","Cat/foo.txt").doesNotMatch("Cat","Cat/foo","blah","bAr","c/z.txt","c/.txt","*");
}

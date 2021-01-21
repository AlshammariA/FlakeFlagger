@Test public void testMatching_various(){
  assertThat("**/[A-Z]*.{[Jj][Aa][Vv][Aa],[Tt][Xx][Tt]}").matches("/foo/bar/Baz.java","/A.java","bar/Test.JAVA","foo/Foo.tXt");
}

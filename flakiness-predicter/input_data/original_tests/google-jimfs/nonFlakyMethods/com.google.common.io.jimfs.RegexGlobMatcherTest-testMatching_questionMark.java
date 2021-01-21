@Test public void testMatching_questionMark(){
  assertThat("?").matches("a","A","$","5","_").doesNotMatch("/","ab","");
  assertThat("??").matches("ab");
  assertThat("????").matches("1234");
  assertThat("?oo?").matches("book","doom").doesNotMatch("/oom");
  assertThat("/?oo/ba?").matches("/foo/bar");
  assertThat("foo.?").matches("foo.h");
  assertThat("foo.??").matches("foo.cc");
}

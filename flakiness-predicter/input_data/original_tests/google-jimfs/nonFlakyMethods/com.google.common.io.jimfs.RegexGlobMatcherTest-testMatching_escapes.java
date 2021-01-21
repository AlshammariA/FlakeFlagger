@Test public void testMatching_escapes(){
  assertThat("\\\\").matches("\\");
  assertThat("\\*").matches("*");
  assertThat("\\*\\*").matches("**");
  assertThat("\\[").matches("[");
  assertThat("\\{").matches("{");
  assertThat("\\a").matches("a");
  assertThat("{a,\\}}").matches("a","}");
  assertThat("{a\\,,b}").matches("a,","b").doesNotMatch("a",",");
}

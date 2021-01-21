@Test public void testMatching_brackets(){
  assertThat("[ab]").matches("a","b").doesNotMatch("ab","ba","aa","bb","c","","/");
  assertThat("[a-d]").matches("a","b","c","d").doesNotMatch("e","f","z","aa","ab","abcd","","/");
  assertThat("[a-dz]").matches("a","b","c","d","z").doesNotMatch("e","f","aa","ab","dz","","/");
  assertThat("[!b]").matches("a","c","d","0","!","$").doesNotMatch("b","/","","ac");
  assertThat("[!b-d3]").matches("a","e","f","0","1","2","4").doesNotMatch("b","c","d","3");
  assertThat("[-]").matches("-");
  assertThat("[-a-c]").matches("-","a","b","c");
  assertThat("[!-a-c]").matches("d","e","0").doesNotMatch("a","b","c","-");
  assertThat("[\\d]").matches("\\","d").doesNotMatch("0","1");
  assertThat("[\\s]").matches("\\","s").doesNotMatch(" ");
  assertThat("[\\]").matches("\\").doesNotMatch("]");
}

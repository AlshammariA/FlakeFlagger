@Test public void then_Charsequence(){
  then("abc".subSequence(0,1)).contains("a");
}

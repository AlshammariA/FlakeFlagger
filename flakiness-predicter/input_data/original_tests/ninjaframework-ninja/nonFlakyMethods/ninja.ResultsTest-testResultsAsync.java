@Test public void testResultsAsync(){
  Result result=Results.async();
  assertTrue(result instanceof AsyncResult);
}

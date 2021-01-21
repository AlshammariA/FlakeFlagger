@Test public void testResultsNoContent(){
  Result result=Results.noContent();
  assertEquals(Result.SC_204_NO_CONTENT,result.getStatusCode());
  assertTrue(result.getRenderable() instanceof NoHttpBody);
}

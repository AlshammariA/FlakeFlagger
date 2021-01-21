@Test public void merge(){
  assertEquals("+",doMerge("+",""));
  assertEquals("-",doMerge("-",""));
  assertEquals("^",doMerge("^",""));
  assertEquals("+",doMerge("+"));
  assertEquals("^",doMerge("-","+"));
  assertEquals("^",doMerge("^","-","+"));
  assertEquals("+",doMerge("+","^","-","+"));
  assertEquals("-",doMerge("-"));
  assertEquals("-",doMerge("^","-"));
  assertEquals("",doMerge("+","^","-"));
  assertEquals("-",doMerge("-","+","^","-"));
  assertEquals("^",doMerge("^"));
  assertEquals("+",doMerge("+","^"));
  assertEquals("^",doMerge("-","+","^"));
  assertEquals("^",doMerge("^","-","+","^"));
}

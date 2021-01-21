@Test public void testEmptyRestriction(){
  GlobPattern gp=GlobPattern.create("/","");
  Map<String,Boolean> tests=new HashMap<String,Boolean>();
  tests.put("/",true);
  tests.put("/a/b/c/d",false);
  tests.put("/a/b/c/d/e",false);
  tests.put("/a/b/c/d/e/f",false);
  tests.put("/a/b/c",false);
  tests.put("/a",false);
  tests.put("/a/b/cde",false);
  for (  String toTest : tests.keySet()) {
    assertTrue(gp + " : " + toTest,tests.get(toTest) == gp.matches(toTest));
  }
  gp=GlobPattern.create("/a/b/c","");
  tests=new HashMap<String,Boolean>();
  tests.put("/a/b/c",true);
  tests.put("/a/b/c/d",false);
  tests.put("/a/b/c/d/e",false);
  tests.put("/a/b/c/d/e/f",false);
  tests.put("/",false);
  tests.put("/a",false);
  tests.put("/a/b/cde",false);
  for (  String toTest : tests.keySet()) {
    assertTrue(gp + " : " + toTest,tests.get(toTest) == gp.matches(toTest));
  }
}

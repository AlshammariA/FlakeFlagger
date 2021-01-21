@Test public void testMatchesWildcardAll(){
  Map<String,Boolean> tests=new HashMap<String,Boolean>();
  GlobPattern gp=GlobPattern.create("/a/b/c","*");
  tests.put("/a/b/c",true);
  tests.put("/a/b/c/d",true);
  tests.put("/a/b/c/d/e",true);
  tests.put("/a/b/c/d/e/f",true);
  tests.put("/a/b/cde",true);
  tests.put("/a/b/cde/e/f",true);
  tests.put("/",false);
  tests.put("/a",false);
  tests.put("/b/c",false);
  for (  String testPath : tests.keySet()) {
    assertMatch(gp,testPath,tests.get(testPath));
  }
  gp=GlobPattern.create("/a/b/c","*e");
  tests=new HashMap<String,Boolean>();
  tests.put("/a/b/c/e",true);
  tests.put("/a/b/c/d/e",true);
  tests.put("/a/b/c/gge",true);
  tests.put("/a/b/c/d/gge",true);
  tests.put("/a/b/ce",true);
  tests.put("/a/b/chee",true);
  tests.put("/a/b/cd/e",true);
  tests.put("/a/b/cd/f/e",true);
  tests.put("/a/b/cd/e",true);
  tests.put("/a/b/cd/f/e",true);
  tests.put("/",false);
  tests.put("/a",false);
  tests.put("/b/c",false);
  tests.put("/a/b/c",false);
  tests.put("/a/b/c/d",false);
  tests.put("/a/b/c/d/e/f",false);
  tests.put("/a/b/c/d/f/e/f",false);
  tests.put("/a/b/c/d/f/efg",false);
  tests.put("/a/b/c/d/f/f",false);
  tests.put("/a/b/c/e/f",false);
  tests.put("/a/b/ce/",false);
  tests.put("/a/b/ceg",false);
  for (  String testPath : tests.keySet()) {
    assertMatch(gp,testPath,tests.get(testPath));
  }
  gp=GlobPattern.create("/a/b/c","*/e");
  tests=new HashMap<String,Boolean>();
  tests.put("/a/b/c/e",true);
  tests.put("/a/b/c/d/e",true);
  tests.put("/a/b/cd/e",true);
  tests.put("/a/b/cd/f/e",true);
  tests.put("/",false);
  tests.put("/a",false);
  tests.put("/b/c",false);
  tests.put("/a/b/c",false);
  tests.put("/a/b/c/d",false);
  tests.put("/a/b/c/d/e/f",false);
  tests.put("/a/b/c/d/f/e/f",false);
  tests.put("/a/b/c/d/f/efg",false);
  tests.put("/a/b/c/d/f/f",false);
  tests.put("/a/b/c/e/f",false);
  tests.put("/a/b/ce/",false);
  for (  String testPath : tests.keySet()) {
    assertMatch(gp,testPath,tests.get(testPath));
  }
  gp=GlobPattern.create("/a/b/c/e","*");
  tests=new HashMap<String,Boolean>();
  tests.put("/a/b/c/e/f/g/h",true);
  tests.put("/a/b/c/e/d/e/f",true);
  tests.put("/a/b/c/e/d/e/f",true);
  tests.put("/a/b/c/e",true);
  tests.put("/a/b/c/e/",true);
  tests.put("/a/b/c/ef",true);
  tests.put("/a/b/c/ef/g",true);
  tests.put("/a/b/ce/f/g/h",false);
  tests.put("/a/b/ce/d/e/f",false);
  tests.put("/a/b/c",false);
  tests.put("/a/b/c/d",false);
  tests.put("/a/b/c/d/e/f",false);
  tests.put("/a/b/c/d/f/f",false);
  tests.put("/a/b/c/d/f/e/f",false);
  tests.put("/a/b/cee/d/e/f",false);
  for (  String testPath : tests.keySet()) {
    assertMatch(gp,testPath,tests.get(testPath));
  }
  gp=GlobPattern.create("/a/b/c/e","/*");
  tests=new HashMap<String,Boolean>();
  tests.put("/a/b/c/e/f/g/h",true);
  tests.put("/a/b/c/e/d/e/f",true);
  tests.put("/a/b/c/e",false);
  tests.put("/a/b/c/e/",false);
  tests.put("/a/b/c/ef",false);
  tests.put("/a/b/ce/f/g/h",false);
  tests.put("/a/b/ce/d/e/f",false);
  tests.put("/a/b/c",false);
  tests.put("/a/b/c/d",false);
  tests.put("/a/b/c/d/e",false);
  tests.put("/a/b/c/d/e/f",false);
  tests.put("/a/b/c/d/f/f",false);
  tests.put("/a/b/c/d/f/e/f",false);
  tests.put("/a/b/cee/d/e/f",false);
  for (  String testPath : tests.keySet()) {
    assertMatch(gp,testPath,tests.get(testPath));
  }
  gp=GlobPattern.create("/a/b/c","e/*");
  tests=new HashMap<String,Boolean>();
  tests.put("/a/b/ce/f/g/h",true);
  tests.put("/a/b/ce/d/e/f",true);
  tests.put("/a/b/c",false);
  tests.put("/a/b/ce",false);
  tests.put("/a/b/c/d",false);
  tests.put("/a/b/c/d/e",false);
  tests.put("/a/b/c/d/e/f",false);
  tests.put("/a/b/c/d/f/f",false);
  tests.put("/a/b/c/d/f/e/f",false);
  tests.put("/a/b/cee/d/e/f",false);
  tests.put("/a/b/ce/",false);
  for (  String testPath : tests.keySet()) {
    assertMatch(gp,testPath,tests.get(testPath));
  }
  gp=GlobPattern.create("/","*");
  tests=new HashMap<String,Boolean>();
  tests.put("/a",true);
  tests.put("/b/",true);
  tests.put("/c/d",true);
  tests.put("/a/b/ce/",true);
  tests.put("/a/b/ce/f/g/h",true);
  tests.put("/a/b/ce/d/e/f",true);
  tests.put("/",false);
  for (  String testPath : tests.keySet()) {
    assertMatch(gp,testPath,tests.get(testPath));
  }
  gp=GlobPattern.create("/a/b/c","*e/*");
  tests=new HashMap<String,Boolean>();
  tests.put("/a/b/ceeeeeee/f/g/h",true);
  tests.put("/a/b/cde/d/e/f",true);
  tests.put("/a/b/c/d/e/f",true);
  tests.put("/a/b/ced/d/e/f",true);
  tests.put("/a/b/ce/",false);
  tests.put("/a/b/c/d/e/",false);
  tests.put("/a/b/c/d",false);
  tests.put("/a/b/c/d/e",false);
  tests.put("/a/b/c/d/f/f",false);
  tests.put("/a/b/c/ed/f/f",false);
  for (  String testPath : tests.keySet()) {
    assertMatch(gp,testPath,tests.get(testPath));
  }
  gp=GlobPattern.create("/a/b/c","/*cat");
  tests=new HashMap<String,Boolean>();
  tests.put("/a/b/c/cat",true);
  tests.put("/a/b/c/acat",true);
  tests.put("/a/b/c/f/cat",true);
  tests.put("/a/b/c/f/acat",true);
  tests.put("/a/b/c/d",false);
  tests.put("/a/b/c/d/cat/e",false);
  tests.put("/a/b/c/d/acat/e",false);
  tests.put("/a/b/c/d/cata/e",false);
  tests.put("/a/b/c/d/cate",false);
  tests.put("/a/b/cat",false);
  tests.put("/a/b/cat/ed/f/f",false);
  tests.put("/a/b/ced/cat",false);
  for (  String testPath : tests.keySet()) {
    assertMatch(gp,testPath,tests.get(testPath));
  }
  gp=GlobPattern.create("/a/b/c","/*/cat");
  tests=new HashMap<String,Boolean>();
  tests.put("/a/b/c/a/cat",true);
  tests.put("/a/b/c/d/e/f/cat",true);
  tests.put("/a/b/c/cat",false);
  tests.put("/a/b/c/cate",false);
  tests.put("/a/b/c/acat",false);
  tests.put("/a/b/c/cat/d",false);
  tests.put("/a/b/c/d/acat",false);
  tests.put("/a/b/c/d/cate",false);
  tests.put("/a/b/c/d/cat/e",false);
  tests.put("/a/b/c/d/acat/e",false);
  tests.put("/a/b/c/d/cata/e",false);
  tests.put("/a/b/cat",false);
  tests.put("/a/b/cat/ed/f/f",false);
  tests.put("/a/b/ced/cat",false);
  tests.put("/a/b/ced/f/cat",false);
  for (  String testPath : tests.keySet()) {
    assertMatch(gp,testPath,tests.get(testPath));
  }
  gp=GlobPattern.create("/a/b/c","/cat*");
  tests=new HashMap<String,Boolean>();
  tests.put("/a/b/c/cat",true);
  tests.put("/a/b/c/cats",true);
  tests.put("/a/b/c/cat/s",true);
  tests.put("/a/b/c/cats/d/e/f",true);
  tests.put("/a/b/c/d/cat",false);
  tests.put("/a/b/c/d/cats",false);
  tests.put("/a/b/c/d/e/cat",false);
  tests.put("/a/b/c/d/e/cats",false);
  tests.put("/a/b/c/acat",false);
  tests.put("/a/b/c/d/acat",false);
  tests.put("/a/b/c/d/cat/e",false);
  tests.put("/a/b/c/d/acat/e",false);
  tests.put("/a/b/c/d/cata/e",false);
  tests.put("/a/b/cat",false);
  tests.put("/a/b/cat/ed/f/f",false);
  tests.put("/a/b/ced/cat",false);
  tests.put("/a/b/ced/f/cat",false);
  for (  String testPath : tests.keySet()) {
    assertMatch(gp,testPath,tests.get(testPath));
  }
}

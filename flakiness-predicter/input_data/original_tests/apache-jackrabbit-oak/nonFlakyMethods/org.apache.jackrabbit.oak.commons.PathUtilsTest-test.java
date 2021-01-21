private static void test(String parent,String child){
  assertEquals(0,getElementCount(""));
  assertEquals(0,getElementCount("/"));
  assertEquals(1,getElementCount(parent));
  assertEquals(2,getElementCount(parent + "/" + child));
  assertEquals(1,getElementCount("/" + parent));
  assertEquals(2,getElementCount("/" + parent + "/"+ child));
  assertEquals(3,getElementCount("/" + parent + "/"+ child+ "/"+ child));
  assertEquals(parent,getElement(parent,0));
  assertEquals(parent,getElement(parent + "/" + child,0));
  assertEquals(child,getElement(parent + "/" + child,1));
  assertEquals(child,getElement(parent + "/" + child+ "/"+ child+ "1",1));
  assertEquals(child + "1",getElement(parent + "/" + child+ "/"+ child+ "1",2));
  assertEquals(parent + "/" + child,PathUtils.concat(parent,child));
  try {
    assertEquals(parent + "/" + child,PathUtils.concat(parent + "/","/" + child));
    if (assertsEnabled) {
      fail();
    }
  }
 catch (  AssertionFailedError e) {
    throw e;
  }
catch (  IllegalArgumentException e) {
    if (assertsEnabled) {
      throw e;
    }
  }
catch (  AssertionError e) {
    if (!assertsEnabled) {
      throw e;
    }
  }
  try {
    assertEquals(parent + "/" + child,PathUtils.concat(parent,"/" + child));
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
  assertEquals(parent + "/" + child+ "/"+ child,PathUtils.concat(parent,child,child));
  assertEquals(parent + "/" + child,PathUtils.concat(parent,"",child));
  assertEquals(parent + "/" + child,PathUtils.concat(parent,child,""));
  assertEquals(child + "/" + child,PathUtils.concat("",child,child));
  assertEquals(child,PathUtils.concat("",child,""));
  assertEquals(child,PathUtils.concat("","",child));
  assertEquals(child,PathUtils.concat("",child));
  assertEquals("/" + child,PathUtils.concat("","/" + child));
  assertEquals(parent + "/" + child,PathUtils.concat(parent,child));
  try {
    PathUtils.concat("/" + parent,"/" + child);
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
  try {
    PathUtils.concat("","//");
    if (assertsEnabled) {
      fail();
    }
  }
 catch (  AssertionFailedError e) {
    throw e;
  }
catch (  AssertionError e) {
  }
  try {
    PathUtils.concat("/","/");
    if (assertsEnabled) {
      fail();
    }
  }
 catch (  AssertionFailedError e) {
    throw e;
  }
catch (  IllegalArgumentException e) {
  }
  assertTrue(PathUtils.denotesRoot("/"));
  assertFalse(PathUtils.denotesRoot("/" + parent));
  assertEquals("",PathUtils.getName("/"));
  assertEquals(parent,PathUtils.getName("/" + parent));
  assertEquals(child,PathUtils.getName("/" + parent + "/"+ child));
  assertEquals("/",PathUtils.getParentPath("/"));
  assertEquals("/",PathUtils.getParentPath("/" + parent));
  assertEquals("/" + parent,PathUtils.getParentPath("/" + parent + "/"+ child));
  assertEquals("/",PathUtils.getAncestorPath("/",1));
  assertEquals("/",PathUtils.getAncestorPath("/" + parent,1));
  assertEquals("/" + parent,PathUtils.getAncestorPath("/" + parent + "/"+ child,1));
  assertEquals("/" + parent + "/"+ child,PathUtils.getAncestorPath("/" + parent + "/"+ child,0));
  assertEquals("/",PathUtils.getAncestorPath("/" + parent + "/"+ child,2));
  assertEquals(PathUtils.getParentPath("/foo"),PathUtils.getAncestorPath("/foo",1));
  assertEquals(PathUtils.getParentPath("/foo/bar"),PathUtils.getAncestorPath("/foo/bar",1));
  assertEquals(PathUtils.getParentPath("foo/bar"),PathUtils.getAncestorPath("foo/bar",1));
  assertEquals(PathUtils.getParentPath("foo"),PathUtils.getAncestorPath("foo",1));
  assertEquals(true,PathUtils.isAbsolute("/"));
  assertEquals(false,PathUtils.isAbsolute(parent));
  assertEquals(true,PathUtils.isAbsolute("/" + parent));
  assertEquals(false,PathUtils.isAbsolute(child));
  assertEquals(true,PathUtils.isAbsolute("/" + parent + "/"+ child));
  assertEquals(false,PathUtils.isAbsolute(parent + "/" + child));
  assertFalse(PathUtils.isAncestor("/","/"));
  assertFalse(PathUtils.isAncestor("/" + parent,"/" + parent));
  assertFalse(PathUtils.isAncestor(parent,parent));
  assertTrue(PathUtils.isAncestor("/","/" + parent));
  assertTrue(PathUtils.isAncestor(parent,parent + "/" + child));
  assertFalse(PathUtils.isAncestor("/",parent + "/" + child));
  assertTrue(PathUtils.isAncestor("/" + parent,"/" + parent + "/"+ child));
  assertFalse(PathUtils.isAncestor(parent,child));
  assertFalse(PathUtils.isAncestor("/" + parent,"/" + parent + "123"));
  assertFalse(PathUtils.isAncestor("/" + parent,"/" + parent + "123/foo"));
  assertEquals("",PathUtils.relativize("/","/"));
  assertEquals("",PathUtils.relativize("/" + parent,"/" + parent));
  assertEquals(child,PathUtils.relativize("/" + parent,"/" + parent + "/"+ child));
  assertEquals(parent + "/" + child,PathUtils.relativize("/","/" + parent + "/"+ child));
  try {
    PathUtils.relativize("x/y","y/x");
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
}

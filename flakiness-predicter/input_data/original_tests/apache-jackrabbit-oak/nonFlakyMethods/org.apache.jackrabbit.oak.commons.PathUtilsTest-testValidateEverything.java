public void testValidateEverything(){
  String invalid="/test/test//test/test";
  try {
    PathUtils.denotesRoot(invalid);
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
    PathUtils.concat(invalid,"x");
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
    PathUtils.concat("/x",invalid);
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
    PathUtils.concat("/x","y",invalid);
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
    PathUtils.concat(invalid,"y","z");
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
    PathUtils.getDepth(invalid);
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
    PathUtils.getName(invalid);
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
    PathUtils.getNextSlash(invalid,0);
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
    PathUtils.getParentPath(invalid);
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
    PathUtils.isAbsolute(invalid);
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
    PathUtils.relativize(invalid,invalid);
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
    PathUtils.relativize("/test",invalid);
    if (assertsEnabled) {
      fail();
    }
  }
 catch (  AssertionFailedError e) {
    throw e;
  }
catch (  AssertionError e) {
  }
}

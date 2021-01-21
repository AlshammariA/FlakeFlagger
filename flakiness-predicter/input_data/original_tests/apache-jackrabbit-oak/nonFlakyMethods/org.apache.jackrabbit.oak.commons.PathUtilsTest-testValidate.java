public void testValidate(){
  for (  String invalid : new String[]{"//","//test","/test/","test/","/test//","/test//test","//x","/x/","x/","/x//","/x//x"}) {
    try {
      PathUtils.validate(invalid);
      fail(invalid);
    }
 catch (    IllegalArgumentException e) {
    }
  }
  for (  String valid : new String[]{"","/","test","test/test","/test","/test/test","x","x/x","/x","/x/x"}) {
    PathUtils.validate(valid);
  }
  try {
    PathUtils.concat("","/test","");
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
}

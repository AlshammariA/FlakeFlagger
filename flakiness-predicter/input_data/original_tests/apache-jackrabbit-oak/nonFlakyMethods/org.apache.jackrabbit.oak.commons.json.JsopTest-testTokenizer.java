public void testTokenizer(){
  assertEquals("test",JsopTokenizer.decode("test"));
  assertEquals("test",JsopTokenizer.decodeQuoted("\"test\""));
  assertEquals("hello\n" + "world",JsopTokenizer.decodeQuoted("\"hello\\n" + "world\""));
  try {
    JsopTokenizer.decodeQuoted("test");
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
  try {
    JsopTokenizer.decode("test\\");
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
  try {
    JsopTokenizer.decode("wrong\\uxxxx");
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
  try {
    JsopTokenizer.decode("wrong\\m");
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
  test("/error/","\"\\");
  test("/error/1",".1");
  assertEquals("x",new JsopTokenizer("x").toString());
  test("/id:truetrue/","true" + "true");
  test("/id:truer/","truer");
  test("/id:falsehood/","falsehood");
  test("/id:nil/","nil");
  test("/id:nil/1","nil 1");
  test("/error/","\"invalid");
  test("- \"test/test\"","-\"test\\/test\"");
  test(" {\n\"x\": 1,\n\"y\": 2\n}\n","{\"x\":1, \"y\":2}");
  test("[true, false, null]","[true, false, null]");
  test("\"\"","\"\"");
  test("\"\\u0003\"","\"\\u0003\"");
  test("\"\\u0012\"","\"\\u0012\"");
  test("\"\\u0123\"","\"\\u0123\"");
  test("\"\\u1234\"","\"\\u1234\"");
  test("\"-\\\\-\\\"-\\b-\\f-\\n-\\r-\\t\"","\"-\\\\-\\\"-\\b-\\f-\\n-\\r-\\t\"");
  test("\"-\\b-\\f-\\n-\\r-\\t\"","\"-\b-\f-\n-\r-\t\"");
  test("[0, 12, -1, 0.1, -0.1, -2.3e1, 1e+1, 1.e-20]","[0,12,-1,0.1,-0.1,-2.3e1,1e+1,1.e-20]");
  test("\"Hello\"","\"Hello\"");
  test("[]","[]");
  test(" {\n\n}\n","{}");
  test(" {\n\"a\": /* test */ 10\n}\n","{ \"a\": /* test */ 10}");
  test("+ - / ^ ","+ - / ^");
  test("/*/ comment /*/ ","/*/ comment /*/");
  test("/**/ /id:comment//**/ ","/**/ comment /**/");
  JsopTokenizer t=new JsopTokenizer("{}123");
  assertFalse(t.matches('+'));
  assertTrue(t.matches('{'));
  t.read('}');
  try {
    t.read('+');
    fail();
  }
 catch (  IllegalArgumentException e) {
    assertEquals("{}123[*] expected: '+'",e.getMessage());
  }
  try {
    t.read(JsopReader.STRING);
    fail();
  }
 catch (  IllegalArgumentException e) {
    assertEquals("{}123[*] expected: string",e.getMessage());
  }
}

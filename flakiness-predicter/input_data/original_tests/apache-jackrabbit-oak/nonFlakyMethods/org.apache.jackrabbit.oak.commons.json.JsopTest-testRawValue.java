public void testRawValue(){
  JsopTokenizer t;
  t=new JsopTokenizer("");
  try {
    t.readRawValue();
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
  t=new JsopTokenizer("[unclosed");
  try {
    t.readRawValue();
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
  t=new JsopTokenizer("{\"x\": [1], null, true, {\"y\": 1}, [1, 2], [], [[1]], +error+}");
  t.read('{');
  assertEquals("x",t.readString());
  t.read(':');
  assertEquals("[1]",t.readRawValue());
  t.read(',');
  assertEquals("null",t.readRawValue());
  t.read(',');
  assertEquals("true",t.readRawValue());
  t.read(',');
  assertEquals("{\"y\": 1}",t.readRawValue());
  t.read(',');
  assertEquals("[1, 2]",t.readRawValue());
  t.read(',');
  assertEquals("[]",t.readRawValue());
  t.read(',');
  assertEquals("[[1]]",t.readRawValue());
  t.read(',');
  try {
    t.readRawValue();
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
}

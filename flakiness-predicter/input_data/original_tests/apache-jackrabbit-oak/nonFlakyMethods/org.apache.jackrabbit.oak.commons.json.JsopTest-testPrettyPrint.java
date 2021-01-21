public void testPrettyPrint(){
  assertEquals("{}",JsopBuilder.prettyPrint("{}"));
  assertEquals("{\n  \"a\": 1,\n  \"b\": \"Hello\"\n}",JsopBuilder.prettyPrint("{\"a\":1,\"b\":\"Hello\"}"));
  assertEquals("{\n  \"a\": [1, 2]\n}",JsopBuilder.prettyPrint("{\"a\":[1, 2]}"));
}

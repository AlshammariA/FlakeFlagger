@Test public void testInvalidSyntax(){
  assertSyntaxError("\\");
  assertSyntaxError("[");
  assertSyntaxError("[]");
  assertSyntaxError("{");
  assertSyntaxError("{{}");
  assertSyntaxError("{a,b,a{b,c},d}");
}

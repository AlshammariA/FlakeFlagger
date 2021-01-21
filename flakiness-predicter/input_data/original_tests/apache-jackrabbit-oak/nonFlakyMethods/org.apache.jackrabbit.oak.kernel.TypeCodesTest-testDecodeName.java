@Test public void testDecodeName(){
  String strFoo="str:foo";
  assertEquals("foo",TypeCodes.decodeName(TypeCodes.split(strFoo),strFoo));
  String str="str:";
  assertEquals("",TypeCodes.decodeName(TypeCodes.split(str),str));
  String any="any";
  assertEquals("any",TypeCodes.decodeName(TypeCodes.split(any),any));
  String empty="";
  assertEquals("",TypeCodes.decodeName(TypeCodes.split(empty),empty));
}

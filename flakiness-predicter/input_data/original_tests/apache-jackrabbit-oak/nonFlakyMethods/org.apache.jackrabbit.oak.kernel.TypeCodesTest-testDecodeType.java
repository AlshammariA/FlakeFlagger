@Test public void testDecodeType(){
  String strFoo="str:foo";
  assertEquals(PropertyType.STRING,TypeCodes.decodeType(TypeCodes.split(strFoo),strFoo));
  String str="str:";
  assertEquals(PropertyType.STRING,TypeCodes.decodeType(TypeCodes.split(str),str));
  String any="any";
  assertEquals(PropertyType.UNDEFINED,TypeCodes.decodeType(TypeCodes.split(any),any));
  String empty="";
  assertEquals(PropertyType.UNDEFINED,TypeCodes.decodeType(TypeCodes.split(empty),empty));
}

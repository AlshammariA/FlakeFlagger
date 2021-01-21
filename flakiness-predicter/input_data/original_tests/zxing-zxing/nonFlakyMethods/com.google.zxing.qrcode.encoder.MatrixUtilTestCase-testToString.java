@Test public void testToString(){
  ByteMatrix array=new ByteMatrix(3,3);
  array.set(0,0,0);
  array.set(1,0,1);
  array.set(2,0,0);
  array.set(0,1,1);
  array.set(1,1,0);
  array.set(2,1,1);
  array.set(0,2,-1);
  array.set(1,2,-1);
  array.set(2,2,-1);
  String expected=" 0 1 0\n" + " 1 0 1\n" + "      \n";
  assertEquals(expected,array.toString());
}

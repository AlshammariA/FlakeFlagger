@Test public void then_byte_array(){
  then(new byte[]{10,11}).contains((byte)11);
}

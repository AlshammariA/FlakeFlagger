@Test public void then_Object_array(){
  then(new Object[]{new Object(),new Object()}).hasSize(2);
}

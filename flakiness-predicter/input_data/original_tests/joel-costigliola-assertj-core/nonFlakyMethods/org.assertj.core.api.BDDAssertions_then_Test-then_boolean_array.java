@Test public void then_boolean_array(){
  then(new boolean[]{true,false}).isEqualTo(new boolean[]{true,false});
}

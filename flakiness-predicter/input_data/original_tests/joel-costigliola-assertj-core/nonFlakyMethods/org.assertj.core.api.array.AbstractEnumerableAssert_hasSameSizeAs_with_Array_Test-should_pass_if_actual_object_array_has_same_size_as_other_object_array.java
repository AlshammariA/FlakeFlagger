@Test public void should_pass_if_actual_object_array_has_same_size_as_other_object_array(){
  assertThat(new String[]{"1","2"}).hasSameSizeAs(new Byte[]{2,3});
  assertThat(new String[]{"1","2"}).hasSameSizeAs(new String[]{"1","2"});
}

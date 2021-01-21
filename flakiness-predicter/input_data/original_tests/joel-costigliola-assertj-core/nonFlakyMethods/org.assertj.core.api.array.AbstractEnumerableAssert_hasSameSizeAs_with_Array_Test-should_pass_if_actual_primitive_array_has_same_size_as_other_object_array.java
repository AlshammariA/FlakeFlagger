@Test public void should_pass_if_actual_primitive_array_has_same_size_as_other_object_array(){
  assertThat(new byte[]{1,2}).hasSameSizeAs(new Byte[]{2,3});
  assertThat(new int[]{1,2}).hasSameSizeAs(new String[]{"1","2"});
}

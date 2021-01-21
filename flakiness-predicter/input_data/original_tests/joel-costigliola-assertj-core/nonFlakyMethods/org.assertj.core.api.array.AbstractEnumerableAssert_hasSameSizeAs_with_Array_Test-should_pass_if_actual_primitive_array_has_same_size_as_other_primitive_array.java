@Test public void should_pass_if_actual_primitive_array_has_same_size_as_other_primitive_array(){
  assertThat(new byte[]{1,2}).hasSameSizeAs(new byte[]{2,3});
  assertThat(new byte[]{1,2}).hasSameSizeAs(new int[]{2,3});
}

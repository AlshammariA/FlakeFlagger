/** 
 * This test proves that Sass Engine behave strangely after the first failure.
 */
@Test public void shouldSucceedAfterAFailure() throws Exception {
  try {
    processor.process(null,new StringReader("$base= #f938ab;"),new StringWriter());
    fail("Should have failed");
  }
 catch (  final Exception e) {
  }
  final String sass=".valid {color: red}  @mixin rounded($side, $radius: 10px) { border-#{$side}-radius: $radius; -moz-border-radius-#{$side}: $radius; -webkit-border-#{$side}-radius: $radius;}#navbar li { @include rounded(top); }";
  processor.process(null,new StringReader(sass),new StringWriter());
}

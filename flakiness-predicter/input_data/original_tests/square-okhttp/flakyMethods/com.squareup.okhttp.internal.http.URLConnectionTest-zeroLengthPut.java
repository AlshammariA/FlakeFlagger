/** 
 * For example, creating an Amazon S3 bucket ends up as a zero-length POST. 
 */
@Test public void zeroLengthPut() throws IOException, InterruptedException {
  zeroLengthPayload("PUT");
}

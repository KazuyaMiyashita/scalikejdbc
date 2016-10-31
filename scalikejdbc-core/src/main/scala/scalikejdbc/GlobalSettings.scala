package scalikejdbc

/**
 * GlobalSettings for this library
 */
object GlobalSettings {

  /**
   * Disables specifying readOnly/autoCommit explicitly to be compatible with JTA DataSource.
   */
  var jtaDataSourceCompatible: Boolean = false

  /**
   * Driver names to choose column name for auto-generated key retrieval.
   */
  var driverNamesToChooseColumnNameForAutoGeneratedKeyRetrieval: Seq[String] = Seq("oracle.jdbc.driver.OracleDriver")

  /**
   * Enables error logging for all SQL errors.
   */
  var loggingSQLErrors: Boolean = true

  /**
   * Enables logging for connection handling.
   */
  var loggingConnections: Boolean = true

  /**
   * Settings for query timing logs.
   */
  var loggingSQLAndTime: LoggingSQLAndTimeSettings = LoggingSQLAndTimeSettings()

  /**
   * Settings on SQL formatter which is used in query timing logs.
   */
  var sqlFormatter: SQLFormatterSettings = SQLFormatterSettings()

  /**
   * Settings on string-style param binding validator.
   */
  var nameBindingSQLValidator: NameBindingSQLValidatorSettings = NameBindingSQLValidatorSettings()

  type QueryCompletionListener = (String, Seq[Any], Long) => Unit

  /**
   * Event handler to be called every query completion.
   */
  var queryCompletionListener: QueryCompletionListener = (statement: String, params: Seq[Any], millis: Long) => ()

  type QueryFailureListener = (String, Seq[Any], Throwable) => Unit

  /**
   * Event handler to be called every query failure.
   */
  var queryFailureListener: QueryFailureListener = (statement: String, params: Seq[Any], e: Throwable) => ()

  /**
   * Event handler to be called every query completion when specifying tags.
   */
  var taggedQueryCompletionListener: (String, Seq[Any], Long, Seq[String]) => Unit = {
    (statement: String, params: Seq[Any], millis: Long, tags: Seq[String]) => ()
  }

  type TaggedQueryFailureListener = (String, Seq[Any], Throwable, Seq[String]) => Unit

  /**
   * Event handler to be called every query failure when specifying tags.
   */
  var taggedQueryFailureListener: TaggedQueryFailureListener = {
    (statement: String, params: Seq[Any], e: Throwable, tags: Seq[String]) => ()
  }

}

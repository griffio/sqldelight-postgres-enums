package griffio

import app.cash.sqldelight.driver.jdbc.asJdbcDriver
import griffio.queries.Sample

import org.postgresql.ds.PGSimpleDataSource
import java.time.LocalDate

private fun getSqlDriver() = PGSimpleDataSource().apply {
    setURL("jdbc:postgresql://localhost:5432/enum-examples")
    applicationName = "App Main"
}.asJdbcDriver()

fun main() {
    val driver = getSqlDriver()

    val db = Sample(driver)

    db.requestsQueries.insert("Hello, world! Low", "low", LocalDate.now()).executeAsOne()
    db.requestsQueries.insert("Hello, world! Medium", "medium", LocalDate.now()).executeAsOne()
    db.requestsQueries.insert("Hello, world! High", "high", LocalDate.now()).executeAsOne()
    db.requestsQueries.insert("Goodby, world!, Low", "low", LocalDate.now()).executeAsOne()

    db.requestsQueries.selectByPriority("low").executeAsList().forEach { println(it) }

}

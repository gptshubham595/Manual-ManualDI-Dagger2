package com.example.dagger2.di.qualifiers

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SQLDatabaseQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FirebaseDatabaseQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class EmailNotifyQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MessageNotifyQualifier

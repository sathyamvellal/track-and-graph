package com.samco.grapheasy.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.threeten.bp.Period

@Entity(tableName = "average_time_between_stat_table",
    foreignKeys = [
        ForeignKey(
            entity = GraphOrStat::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("graph_stat_id"),
            onDelete = ForeignKey.CASCADE),
        ForeignKey(
            entity = Feature::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("feature_id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class AverageTimeBetweenStat(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", index = true)
    val id: Long,

    @ColumnInfo(name = "graph_stat_id")
    val graphStatId: Long,

    @ColumnInfo(name = "feature_id")
    val featureId: Long,

    @ColumnInfo(name = "value")
    val value: String,

    @ColumnInfo(name = "period")
    val period: Period?
)

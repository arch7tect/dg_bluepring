import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from etl.Transformation where name = :name").setParameter("name", "bp_rdbms_1").uniqueResult() 
entity.userDefinedFunctions.clear()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.targets.find {it.name == "transformations_json"}.context = null
entity.sources.find {it.name == "SQL_transformationstep"}.context = session.createQuery("from etl.JdbcContext where name = :name").setParameter("name", "datagram").uniqueResult()
entity.sources.find {it.name == "etl_transformation"}.context = session.createQuery("from etl.JdbcContext where name = :name").setParameter("name", "datagram").uniqueResult()
entity.sources.find {it.name == "auth_auditinfo"}.context = session.createQuery("from etl.JdbcContext where name = :name").setParameter("name", "datagram").uniqueResult()
entity.sources.find {it.name == "etl_project"}.context = session.createQuery("from etl.JdbcContext where name = :name").setParameter("name", "datagram").uniqueResult()
Context.current.commit()

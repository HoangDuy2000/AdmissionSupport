import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Apis, { endpoint } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import { Col, ListGroup, Row } from "react-bootstrap";

const FacultyDetail = () =>{
    const {facultysId} = useParams();
    const [facultys, setFacultys] = useState(null);
    const [scores, setScores] = useState(null);

    useEffect(()=> {
        const loadFacultys = async() =>{
            let {data} = await Apis.get(endpoint["facultys-details"](facultysId));
            setFacultys(data);
        }

        const loadScores = async() =>{
            let {data} = await Apis.get(endpoint["scores"](facultysId));
            setScores(data);
        }

        loadFacultys();
        loadScores();
    }, [facultysId]);

    if (facultys === null || scores === null)
        return <MySpinner /> ;

    return <>
        <h1 className="text-center text-info mt-2">{facultys.name}</h1>
        <Row>
            <Col md={5} xs={6}>
                <p>{facultys.description}</p>
                <p>{facultys.location}</p>
                <p>{facultys.email}</p>
                <p>{facultys.createdDate}</p>
            </Col>
        </Row>
        <hr />
        <ListGroup>
                {scores.map(s => <ListGroup.Item id={s.id}>
                            {s.score} - {s.date}
                        </ListGroup.Item>)
                }
            </ListGroup>
    </>
}

export default FacultyDetail;
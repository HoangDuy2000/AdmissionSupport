import { useEffect, useState } from "react";
import Apis, { endpoint } from "../configs/Apis";
import { Card, Col, Nav, Row, Spinner } from "react-bootstrap";
import { Link } from "react-router-dom";

const Facultys = () => {
    const [facultys, setFacultys] = useState(null);

    useEffect(() => {
        const loadFacultys = async () =>{
            try{
                let res = await Apis.get(endpoint['facultys']);
                setFacultys(res.data);
            }catch(ex){
                console.error(ex)
            }
            
        }

        loadFacultys();
    }, []);

    if (facultys === null)
        return <Spinner animation="border" variant="primary" />;

    return (
        <Nav>
            <h1 class="mt-3 text-center text-uppercase"><strong>Danh Sách Khoa</strong></h1>
            <Row>
                {facultys.map(f => {
                    return <Col xs={6} md={4}>
                        <div class="mt-4">
                            <Card>
                            <Card.Body style={{ height: '200px'}}>
                                <Card.Title class="text-center text-uppercase" style={{height: '40px'}}><strong><Link class={"text-decoration-none"}>{f.name}</Link></strong></Card.Title>
                                <Card.Text class={"overflow-hidden"} style={{ height: '75px' }}>
                                    {f.description}
                                </Card.Text>
                            </Card.Body>
                            </Card>
                        </div>
                    </Col>
                })}
            </Row>
        </Nav>
    )
}

export default Facultys;
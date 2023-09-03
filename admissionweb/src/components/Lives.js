import { useEffect, useState } from "react";
import { Card, Col, Row, Spinner } from "react-bootstrap";
import { Link } from "react-router-dom";
import Apis, { endpoint } from "../configs/Apis";
import Moment from "react-moment";

const Lives = () => {
    const [lives, setLives] = useState(null);

    useEffect(() => {
        const loadLives = async () => {
            let res = await Apis.get(endpoint["lives"]);
            setLives(res.data);
        }

        loadLives();
    }, []);

    if (lives === null)
        return <Spinner animation="border" variant="primary" />;

    return <>
        <Row class="align-items-center">
            <Col class="mt-3">
            <div class="mb-3">
                <h2 class="card-title">Danh Sách Lịch Livestream</h2>
            </div>
            </Col>
            {lives.map(l => {
                let url = `/lives/${l.id}`;
                return <div class="mt-4">
                    <Card class="mt-4">
                        <Card.Body class="p-4">
                            <Row class="align-items-center">
                                <Col class="lg-5">
                                    <div class="candidate-list-content mt-3 mt-lg-0">
                                        <h5 class="fs-19 mb-0">
                                            <Link class="primary-link text-decoration-none" to={url}>{l.tiltle}</Link>
                                        </h5>
                                        <p class="text-muted mb-2 mt-2"><strong>{l.description}</strong></p>
                                        <ul class="list-inline mb-0 text-muted">
                                            <li class="list-inline-item"><i class="mdi mdi-map-marker"></i>Thời Gian:</li>
                                            <li class="list-inline-item"><i class="mdi mdi-wallet"></i><Moment locale="vi" fromNow>{l.date}</Moment></li>
                                        </ul>
                                    </div>
                                </Col>
                            </Row>
                        </Card.Body>
                    </Card>
                </div>
            })}
        </Row>
    </>
}

export default Lives;